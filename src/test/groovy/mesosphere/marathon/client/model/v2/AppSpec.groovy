package mesosphere.marathon.client.model.v2

import mesosphere.client.common.ModelUtils
import spock.lang.Specification

class AppSpec extends Specification {

  def app = new App()

  def "allows multiple roles"() {
    def firstRole = "arole"
    def secondRole = "another"

    when:
    app.addAcceptedResourceRole(firstRole)

    then:
    app.acceptedResourceRoles.contains(firstRole)

    when:
    app.addAcceptedResourceRole(secondRole)

    then:
    app.acceptedResourceRoles.contains(firstRole)
    app.acceptedResourceRoles.contains(secondRole)

    when:
    app.addAcceptedResourceRole(firstRole)

    then:
    app.acceptedResourceRoles.contains(firstRole)
  }


  def "test add dependency"() {
    def firstDep = "adep"
    def secondDep = "another"

    when:
    app.addDependency(firstDep)

    then:
    app.getDependencies().contains(firstDep)

    when:
    app.addDependency(secondDep)

    then:
    app.getDependencies().contains(firstDep)
    app.getDependencies().contains(secondDep)

    when:
    app.addDependency(firstDep)

    then:
    app.getDependencies().contains(firstDep)

  }

  def "backoff factor checks"() {
    app.backoffFactor = 0.1

    expect:
    app.backoffFactor == 0.1

    when:
    app.backoffFactor = 1d

    then:
    app.backoffFactor == 1.0
  }

  def "test example JSON"() {
    given:
    def json = exampleJSON()

    def app = ModelUtils.GSON.fromJson(json, App.class)
    def portDefs = app.getPortDefinitions()
    def fetch2 = app.fetch[1]
    def discovery = app.ipAddress.discovery

    expect:
    // env
    app.getEnv().get("PASSWORD") == ["secret": "/db/password"]

    // port definitions
    portDefs.size() == 2
    portDefs[0].port == 0
    portDefs[0].protocol == "tcp"
    portDefs[0].name == "http"
    portDefs[0].labels == ["vip": "192.168.0.1:80"]
    portDefs[1].port == 31009
    portDefs[1].protocol == "tcp"
    portDefs[1].labels == ["VIP_0": "3.3.3.3"]

    // fetch
    app.fetch.size() == 2
    fetch2.uri == "https://foo.com/archive.zip"
    !fetch2.executable
    fetch2.extract
    fetch2.cache
    fetch2.outputFile == "newname.zip"

    //secrets
    app.secrets.size() == 2
    app.secrets.secret3.source == "/foo2"

    // ipaddress
    discovery.ports.size() == 1
    discovery.ports[0].number == 8080
    discovery.ports[0].name == "rest-endpoint"
    app.ipAddress.labels["environment"] == "dev"
    app.ipAddress.groups[0] == "dev"
  }

  def exampleJSON() {
    return """
{
  "id": "/foo",
  "instances": 2,
  "cmd": "sleep 1000",
  "cpus": 0.1,
  "disk": 0,
  "mem": 16,
  "acceptedResourceRoles": [
    "mesos_role"
  ],
  "args": [
    "sleep",
    "100"
  ],
  "backoffFactor": 1.15,
  "backoffSeconds": 1,
  "constraints": [
    [
      "hostname",
      "LIKE",
      "srv2.*"
    ]
  ],
  "container": {
    "docker": {
      "forcePullImage": false,
      "image": "mesosphere:marathon/latest",
      "network": "BRIDGE",
      "parameters": [
        {
          "key": "name",
          "value": "kdc"
        }
      ],
      "portMappings": [
        {
          "containerPort": 80,
          "hostPort": 0,
          "protocol": "tcp",
          "servicePort": 10019,
          "name": "http",
          "labels": {
            "vip": "192.168.0.1:80"
          }
        }
      ],
      "privileged": false
    },
    "type": "DOCKER",
    "volumes": [
      {
        "containerPath": "/docker_storage",
        "hostPath": "/hdd/tools/docker/registry",
        "mode": "RW"
      }
    ]
  },
  "dependencies": [
    "/prod/group"
  ],
  "env": {
    "XPS1": "Test",
    "XPS2": "Rest",
    "PASSWORD": {
      "secret": "/db/password"
    }
  },
  "executor": "",
  "healthChecks": [
    {
      "gracePeriodSeconds": 300,
      "ignoreHttp1xx": false,
      "intervalSeconds": 20,
      "maxConsecutiveFailures": 3,
      "path": "/",
      "portIndex": 0,
      "protocol": "HTTP",
      "timeoutSeconds": 20
    }
  ],
  "readinessChecks": [
    {
      "name": "myReadyCheck",
      "protocol": "HTTP",
      "path": "/v1/plan",
      "portName": "http",
      "intervalSeconds": 10,
      "timeoutSeconds": 3,
      "httpStatusCodesForReady": [
        200
      ],
      "preserveLastResponse": true
    }
  ],
  "labels": {
    "owner": "zeus",
    "note": "Away from olympus"
  },
  "maxLaunchDelaySeconds": 3600,
  "ipAddress": {
    "discovery": {
      "ports": [
        {
          "number": 8080,
          "name": "rest-endpoint",
          "protocol": "tcp"
        }
      ]
    },
    "groups": [
      "dev"
    ],
    "labels": {
      "environment": "dev"
    }
  },
  "portDefinitions": [
    {
      "port": 0,
      "protocol": "tcp",
      "name": "http",
      "labels": {
        "vip": "192.168.0.1:80"
      }
    },
    {
      "port": 31009,
      "protocol": "tcp",
      "labels": {
        "VIP_0": "3.3.3.3"
      }
    }
  ],
  "requirePorts": false,
  "upgradeStrategy": {
    "maximumOverCapacity": 1,
    "minimumHealthCapacity": 1
  },
  "fetch": [
    {
      "uri": "https://foo.com/setup.py"
    },
    {
      "uri": "https://foo.com/archive.zip",
      "executable": false,
      "extract": true,
      "cache": true,
      "outputFile": "newname.zip"
    }
  ],
  "user": "root",
  "secrets": {
    "secret1": {
      "source": "/db/password"
    },
    "secret3": {
      "source": "/foo2"
    }
  },
  "taskKillGracePeriodSeconds": 30
}
"""
  }
}
