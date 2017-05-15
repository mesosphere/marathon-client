package mesosphere.marathon.client.model.v2

import spock.lang.Specification
import spock.lang.Subject

class IpDiscoverySpec extends Specification {
    def "setPorts overwrite existing ports"() {
        given:
        @Subject discovery = new IpDiscovery()
        List<IpDiscoveryPort> newPorts = new ArrayList<>(3)
        newPorts.add(new IpDiscoveryPort(80, "nginx", "tcp"))

        when:
        discovery.addPort(8080, "jenkins", "tcp")

        then:
        discovery.ports.size() == 1
        discovery.ports[0].number == 8080
        discovery.ports[0].name == "jenkins"
        discovery.ports[0].protocol == "tcp"

        when:
        discovery.ports = newPorts

        then:
        discovery.ports.size() == 1
        discovery.ports[0].name == "nginx"
    }

    def "AddPort appends to list of ports"() {
        given:
        @Subject discovery = new IpDiscovery()

        when:
        discovery.addPort(new IpDiscoveryPort(8080, "jenkins", "tcp"))

        then:
        discovery.ports.size() == 1
        discovery.ports[0].name == "jenkins"

        when:
        discovery.addPort(5432, "postgres", "tcp")

        then:
        discovery.ports.size() == 2
        discovery.ports[1].name == "postgres"
    }
}
