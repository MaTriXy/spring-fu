package com.sample

import org.springframework.fu.kofu.application
import org.springframework.fu.kofu.web.server
import org.springframework.web.reactive.function.server.router

val router = router {
	GET("/") { ok().syncBody("Hello world!") }
}

val app = application {
	server {
		port = if (profiles.contains("test")) 8181 else 8080
		import(router)
	}
}

fun main() = app.run()
