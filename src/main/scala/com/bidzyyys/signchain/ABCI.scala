package com.bidzyyys.signchain

import java.util.logging.Logger

import io.grpc.{Server, ServerBuilder}

import scala.concurrent.{ExecutionContext, Future}
import tendermint.abci.types.{
  ABCIApplicationGrpc,
  RequestApplySnapshotChunk,
  RequestBeginBlock,
  RequestCheckTx,
  RequestCommit,
  RequestDeliverTx,
  RequestEcho,
  RequestEndBlock,
  RequestFlush,
  RequestInfo,
  RequestInitChain,
  RequestListSnapshots,
  RequestLoadSnapshotChunk,
  RequestOfferSnapshot,
  RequestQuery,
  RequestSetOption,
  ResponseApplySnapshotChunk,
  ResponseBeginBlock,
  ResponseCheckTx,
  ResponseCommit,
  ResponseDeliverTx,
  ResponseEcho,
  ResponseEndBlock,
  ResponseFlush,
  ResponseInfo,
  ResponseInitChain,
  ResponseListSnapshots,
  ResponseLoadSnapshotChunk,
  ResponseOfferSnapshot,
  ResponseQuery,
  ResponseSetOption
}

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
        ABCIApplicationGrpc.bindService(new ABCIImpl, executionContext)
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

  private class ABCIImpl extends ABCIApplicationGrpc.ABCIApplication {

    override def echo(request: RequestEcho): Future[ResponseEcho] = ???

    override def flush(request: RequestFlush): Future[ResponseFlush] = ???

    override def info(request: RequestInfo): Future[ResponseInfo] = ???

    override def setOption(
        request: RequestSetOption
    ): Future[ResponseSetOption] =
      ???

    override def deliverTx(
        request: RequestDeliverTx
    ): Future[ResponseDeliverTx] =
      ???

    override def checkTx(request: RequestCheckTx): Future[ResponseCheckTx] = ???

    override def query(request: RequestQuery): Future[ResponseQuery] = ???

    override def commit(request: RequestCommit): Future[ResponseCommit] = ???

    override def initChain(
        request: RequestInitChain
    ): Future[ResponseInitChain] =
      ???

    override def beginBlock(
        request: RequestBeginBlock
    ): Future[ResponseBeginBlock] = ???

    override def endBlock(request: RequestEndBlock): Future[ResponseEndBlock] =
      ???

    override def listSnapshots(
        request: RequestListSnapshots
    ): Future[ResponseListSnapshots] = ???

    override def offerSnapshot(
        request: RequestOfferSnapshot
    ): Future[ResponseOfferSnapshot] = ???

    override def loadSnapshotChunk(
        request: RequestLoadSnapshotChunk
    ): Future[ResponseLoadSnapshotChunk] = ???

    override def applySnapshotChunk(
        request: RequestApplySnapshotChunk
    ): Future[ResponseApplySnapshotChunk] = ???
  }
}
