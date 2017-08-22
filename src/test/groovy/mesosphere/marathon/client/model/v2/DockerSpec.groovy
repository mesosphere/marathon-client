package mesosphere.marathon.client.model.v2

import mesosphere.client.common.ModelUtils
import spock.lang.Specification


class DockerSpec extends Specification {

  def "docker basics"() {

    def jsonString = """
{
   "id":"test",
   "cmd":"echo",
   "container":{
      "docker":{
        "forcePullImage": false,
        "image": "mesosphere:marathon/latest",
        "network": "BRIDGE",
        "parameters": [
          {
            "key": "name",
            "value": "kdc"
          }
        ],
        "privileged": false
      }
   }
}
"""

    def app = ModelUtils.GSON.fromJson(jsonString, App.class)

    expect:
    def dock = app.container.docker
    dock.image == "mesosphere:marathon/latest"
    !dock.forcePullImage
    !dock.privileged
    dock.network == "BRIDGE"

    dock.parameters.size() == 1
    dock.parameters.each { param ->
      assert param.key == "name"
      assert param.value == "kdc"
    }
  }
}
