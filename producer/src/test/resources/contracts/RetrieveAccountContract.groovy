import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should retrieve account"
    request {
        method GET()
        headers {
            accept(applicationJson())
        }
        url ('/api/v1/accounts'){
            queryParameters {
                parameter("accountId", 1L)
            }
        }
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(file("retrieveAccountResponse.json"))
    }
}