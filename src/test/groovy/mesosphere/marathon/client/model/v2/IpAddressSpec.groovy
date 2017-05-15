package mesosphere.marathon.client.model.v2

import spock.lang.Specification
import spock.lang.Subject

class IpAddressSpec extends Specification {

    def "basics"() {
        given:
        @Subject ipAddress = new IpAddress()

        when:
        ipAddress.setNetworkName("network1")

        then:
        ipAddress.networkName == "network1"

        when:
        ipAddress.setDiscovery(new IpDiscovery())

        then:
        ipAddress.discovery != null

        when:
        ipAddress.setGroups(["dev", "test"])

        then:
        ipAddress.groups[0] == "dev"
        ipAddress.groups[1] == "test"
    }

    def "addGroup appends to group list"() {
        given:
        @Subject ipAddress = new IpAddress()

        when:
        ipAddress.addGroup("prod")

        then:
        ipAddress.groups[0] == "prod"

        when:
        ipAddress.addGroup("staging")

        then:
        ipAddress.groups[1] == "staging"
    }

    def "setGroup overwrites existing group list"() {
        given:
        @Subject ipAddress = new IpAddress()

        when:
        ipAddress.setGroups(["dev", "test"])

        then:
        ipAddress.groups.size() == 2
        ipAddress.groups[0] == "dev"
        ipAddress.groups[1] == "test"

        when:
        ipAddress.setGroups(["production"])

        then:
        ipAddress.groups.size() == 1
        ipAddress.groups[0] == "production"
    }
}
