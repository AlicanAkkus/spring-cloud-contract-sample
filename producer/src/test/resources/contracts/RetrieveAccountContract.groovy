import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should retrieve account"
    request {
        method GET()
        url ('/api/v1/accounts'){
            queryParameters {
                parameter("accountId", 1L)
            }
        }
    }
    response {
        status 200
        body(file("retrieveAccountResponse.json"))
    }
}