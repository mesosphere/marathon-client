package mesosphere.marathon.client.model.v2

import spock.lang.Specification
import spock.lang.Subject

class IpAddressSpec extends Specification {

  def "IpAddress basics"() {
    given:
    @Subject ipAddress = new IpAddress()

    ipAddress.networkName = "network1"
    ipAddress.discovery = new IpDiscovery()
    ipAddress.groups = ["dev", "test"]
    ipAddress.labels = ["foo": "bar", "key1": 3]

    expect:
    ipAddress.discovery
    ipAddress.networkName == "network1"
    ipAddress.groups[0] == "dev"
    ipAddress.groups[1] == "test"
    ipAddress.labels["foo"] == "bar"
    ipAddress.labels["key1"] == 3
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
    ipAddress.groups = ["dev", "test"]

    then:
    ipAddress.groups.size() == 2
    ipAddress.groups[0] == "dev"
    ipAddress.groups[1] == "test"

    when:
    ipAddress.groups = ["production"]

    then:
    ipAddress.groups.size() == 1
    ipAddress.groups[0] == "production"
  }

  def "addLabel adds a label to existing labels"() {
    given:
    @Subject ipAddress = new IpAddress()

    when:
    ipAddress.labels = ["foo": "bar"]

    then:
    ipAddress.labels["foo"] == "bar"

    when:
    ipAddress.addLabel("another", 200)

    then:
    ipAddress.labels.size() == 2
    ipAddress.labels["foo"] == "bar"
    ipAddress.labels["another"] == 200
  }
}
