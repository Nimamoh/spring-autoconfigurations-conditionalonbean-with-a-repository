package net.nimamoh.so.conditionalrepositories.api.controllers

import net.nimamoh.so.conditionalrepositories.api.services.ApiServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.PostConstruct

@RestController
class RestEndpoints(
    private val apiServices: ApiServices
) {

    @GetMapping("/stubs")
    fun stubs(): Collection<String> {
        return apiServices.listStubIdentifiers();
    }

    @PostConstruct
    fun after() {
        println("INITIALIZED REST ENDPOINTS")
        println("NOW LOADING SOME STUFF INTO DB...")
        apiServices.loadSomeStubData()
        println("DONE!")
    }
}