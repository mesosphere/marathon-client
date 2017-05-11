package mesosphere.marathon.client.model.v2

import mesosphere.client.common.ModelUtils
import spock.lang.Specification


class DockerSpec extends Specification {

  def "docker port mappings from strings"() {

    def jsonString = """
{
   "id":"test",
   "cmd":"echo",
   "container":{
      "docker":{
         "image":"ubuntu",
         "portMappings":[
            {
               "containerPort":8080,
               "protocol":"tcp",
               "labels":{
                  "VIP_0":"/foo:8080"
               }
            }
         ]
      }
   }
}
"""

    def app = ModelUtils.GSON.fromJson(jsonString, App.class);

    expect:
    app.container.docker.portMappings.size() == 1
    app.container.docker.portMappings.each {port->
      assert port.containerPort == 8080
      assert port.protocol == "tcp"
      assert port.labels.size() == 1
      assert port.labels == ["VIP_0" : "/foo:8080"]
    }
  }
}
