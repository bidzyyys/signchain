package com.bidzyyys.signchain

import io.grpc.{Server, ServerBuilder}
import java.util.logging.Logger
import scala.concurrent.ExecutionContext
import tendermint.abci.types.ABCIApplicationGrpc

object ABCIServer {
  private val logger = Logger.getLogger(classOf[ABCIServer].getName)

  def main(args: Array[String]): Unit = {
    val server = new ABCIServer(ExecutionContext.global)
    server.start()
    server.blockUntilShutdown()
  }

  private val port = 26658
}

class ABCIServer(executionContext: ExecutionContext) { self =>
  private[this] var server: Server = null

  private def start(): Unit = {
    server = ServerBuilder
      .forPort(ABCIServer.port)
      .addService(
        ABCIApplicationGrpc.bindService(new ABCIServerImpl, executionContext)
      )
      .build
      .start
    ABCIServer.logger.info(
      "ABCI started, listening on " + ABCIServer.port
    )
    sys.addShutdownHook {
      System.err.println(
        "*** shutting down gRPC server since JVM is shutting down"
      )
      self.stop()
      System.err.println("*** server shut down")
    }
  }

  private def stop(): Unit = {
    if (server != null) {
      server.shutdown()
    }
  }

  private def blockUntilShutdown(): Unit = {
    if (server != null) {
      server.awaitTermination()
    }
  }
}
