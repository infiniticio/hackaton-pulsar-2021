package io.infinitic.loadTester.app

import io.infinitic.pulsar.InfiniticAdmin
import org.apache.pulsar.client.admin.PulsarAdmin
import org.apache.pulsar.client.api.PulsarClient
import org.apache.pulsar.client.impl.auth.oauth2.AuthenticationFactoryOAuth2
import java.net.URL


// From the left navigation pane of the StreamNative Cloud Manager, click Manage > Service Accounts > Download  to download the Oauth2 key file to the local path. Then, replace the `YOUR-KEY-FILE-PATH` parameter with the local path for your Oauth2 key file.


fun main() {
    val issuerUrl = "https://auth.streamnative.cloud"
    val credentialsUrl = "file:///Users/gilles/.sncloud/zenaton-gilles.json"
    val audience = "urn:sn:pulsar:zenaton:hackathon"
    val client = PulsarClient.builder()
        .serviceUrl("pulsar+ssl://hackathon.zenaton.snio.cloud:6651")
        .authentication(
            AuthenticationFactoryOAuth2.clientCredentials(URL(issuerUrl), URL(credentialsUrl), audience)
        )
        .build()

    val admin = PulsarAdmin.builder()
        .serviceHttpUrl("https://hackathon.zenaton.snio.cloud")
        .authentication(
            AuthenticationFactoryOAuth2.clientCredentials(URL(issuerUrl), URL(credentialsUrl), audience)
        )
        .build()

    val a = InfiniticAdmin(admin, "infinitic", "hackathon")
    a.setupPulsar()
    a.printTopicStats()

    client.close()
}

