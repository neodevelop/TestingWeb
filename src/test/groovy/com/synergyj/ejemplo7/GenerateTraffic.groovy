@Grapes([
  @Grab("org.codehaus.geb:geb-core:0.7.0"),
  @Grab("org.seleniumhq.selenium:selenium-htmlunit-driver:2.23.1"),
  @Grab("org.seleniumhq.selenium:selenium-support:2.23.1"),
  @Grab("org.codehaus.groovy.modules.http-builder:http-builder:0.5.1")
])

import geb.Browser
import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import static groovyx.gpars.GParsPool.withPool

def peticiones = []
def urls = [
  "http://entrenamiento.synergyj.com",
  "http://entrenamiento.synergyj.com/signup",
  "http://entrenamiento.synergyj.com/login",
  "http://entrenamiento.synergyj.com/calendar"
  ]

1.upto(10000){
  Random rand = new Random()
  peticiones << urls[rand.nextInt(urls.size())]
}

withPool{
    peticiones.eachParallel{ job ->
      llamada(job)
      //withSelenium(job)
    }
}


def withSelenium(url){
  Browser.drive {
    go url
    def t = title
  }
}

def llamada(url){

  def http = new HTTPBuilder(url)


  http.request(GET,TEXT) { req ->
    headers.'User-Agent' = 'Mozilla/5.0'

    response.success = { resp, reader ->
      assert resp.status == 200
      //println "My response handler got response: ${resp.statusLine}"
      //println "Response length: ${resp.headers.'Content-Length'}"
      //System.out << reader // print response reader
    }

    // called only for a 404 (not found) status code:
    response.'404' = { resp ->
      println 'Not found'
    }
  }
}