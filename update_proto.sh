#!/bin/bash

VERSION_BRANCH=${TENDERMINT_VERSION:-v0.33.9}
TENDERMINT_REPO_URL=https://raw.githubusercontent.com/tendermint/tendermint/${VERSION_BRANCH}

GRPC_DIR=src/main/scala/com/bidzyyys/signchain/grpc
PROTOBUF_DIR=src/main/protobuf

TM_ABCI_DIR=${PROTOBUF_DIR}/abci/types
TM_ABCI_FILE_PATH=${TM_ABCI_DIR}/types.proto

TM_KV_DIR=${PROTOBUF_DIR}/libs/kv
TM_KV_FILE_PATH=${TM_KV_DIR}/types.proto

TM_MERKLE_DIR=${PROTOBUF_DIR}/crypto/merkle
TM_MERKLE_FILE_PATH=${TM_MERKLE_DIR}/merkle.proto

THIRD_PARTY_DIR=third_party/proto/gogoproto
THIRD_PARTY_FILE=${THIRD_PARTY_DIR}/gogo.proto
THIRD_PARTY_LOCAL_DIR=${PROTOBUF_DIR}/${THIRD_PARTY_DIR}
THIRD_PARTY_LOCAL_FILE_PATH=${PROTOBUF_DIR}/${THIRD_PARTY_FILE}

update_proto() {
    rm -rf ${PROTOBUF_DIR}

    mkdir -p ${TM_ABCI_DIR}
    mkdir -p ${TM_KV_DIR}
    mkdir -p ${TM_MERKLE_DIR}
    mkdir -p ${THIRD_PARTY_LOCAL_DIR}

    echo Downloading protobuf files

    curl -s ${TENDERMINT_REPO_URL}/abci/types/types.proto >${TM_ABCI_FILE_PATH}
    curl -s ${TENDERMINT_REPO_URL}/libs/kv/types.proto >${TM_KV_FILE_PATH}
    curl -s ${TENDERMINT_REPO_URL}/crypto/merkle/merkle.proto >${TM_MERKLE_FILE_PATH}
    curl -s ${TENDERMINT_REPO_URL}/${THIRD_PARTY_FILE} >${THIRD_PARTY_LOCAL_FILE_PATH}
}

update_proto

