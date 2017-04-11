package mesosphere.marathon.client.model.v2

import spock.lang.Specification

class AppSpec extends Specification {

  def app = new App()

  def "allows multiple roles"() {
    def firstRole = "arole"
    def secondRole = "another"

    when:
    app.addAcceptedResourceRole(firstRole);

    then:
    app.acceptedResourceRoles.contains(firstRole)

    when:
    app.addAcceptedResourceRole(secondRole);

    then:
    app.acceptedResourceRoles.contains(secondRole)

    when:
    app.addAcceptedResourceRole(firstRole);

    then:
    app.acceptedResourceRoles.contains(firstRole)
  }

  
}
