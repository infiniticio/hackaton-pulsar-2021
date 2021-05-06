import io.infinitic.pulsar.InfiniticAdmin
import org.slf4j.LoggerFactory

fun setupPulsar(configFilePath: String) {
  val logger = LoggerFactory.getLogger("setupPulsar")
  logger.info("Setup Pulsar")
  val infiniticAdmin = InfiniticAdmin.fromConfigFile(configFilePath)
  infiniticAdmin.setupPulsar()
  infiniticAdmin.close()
  logger.info("Setup Finished")
}
