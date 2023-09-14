#!/bin/bash

# Variables
RESOURCE_GROUP="test-rg"
LOCATION="eastus"
DEPLOYMENT_NAME="TennisLeagueInfraDeployment"
BICEP_FILE="../bicep/main.bicep"
PARAMETERS_FILE="../bicep/parameters.json"
SSH_KEY="ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQDRWLxq0/WVguXL9Iq6AlLohujYuVHvMikP86dDSMjYVwLGotP4/gsVofxlO1+hu1eaeAnQhNUNm8LfvnSC+uI3lCBXlppQwhDLX685Lk3YJvn72zbbzprr6/eSI/SkQxGYzLWVdgQ/vdQFn/UJtY3WzwgmoZIU1tYOFLv9NAVc3Ph3pXFzM7Y2BWMIo4G2Kr46dua1hlD9kTy8AJc0CD727jzw+bD+pWEIQqsKhFZxLMxD45+i6DE0ILp5gtEi7XQZCsEVAbGVTO34SRgZBNI613SYNoQwsAa+ICwOAI7HjpaTw5YDj7C8W6qPnJR1BeY//r5UwAUB35tdJjmT2aDqwTTg2fVsYRojEZYTv6u9Z7pIUfoE4GB5ap1/dEiULEBw32ySQeUpMDuSYCScoHQ7F9yALVkxpRFRxJLtxK3/lamHz6CsGk5d0X7MkDi1+Hv0EEQPifZz9XWaIe0wBI//Tsi6PwH/Snd8i5AyCy9v6keVf5vwDhcINJE4FVXuOdtqmZFhgMxMGUEyorhtWsRKovjjZxgKykh/wvo081y7TVYGaWVIBbNuE++g4EccmT3FgydY5LygR7vSKY//7e4Tf7MZOdngduoszOR4muoEmzA0tQU37efo9oCyaz36pBPowlNx8fAig6NCuKLDqkL3GYRSryXVLidX2C0k+PpnKw=="
SERVICE_PRINCIPAL_CLIENT_ID="1b2c2f56-4180-4804-bf62-d31f8b222fd2"
SERVICE_PRINCIPAL_SECRET="P7_8Q~FOida6AshIPFcHvpPQ9.RWfPAWA.7lgdv2"

# Login to Azure (uncomment this if you want to include Azure login in the script)
# az login

# Create Resource Group
az group create --name $RESOURCE_GROUP --location $LOCATION

# Build the Bicep file
#bicep build $BICEP_FILE

echo 'ssh key -' $SSH_KEY
# Deploy the Bicep file
az deployment group create \
  --name $DEPLOYMENT_NAME \
  --resource-group $RESOURCE_GROUP \
  --template-file "${BICEP_FILE}" \
  --parameters mysqlAdminPassword=radhika19$ mysqlServerName=testsql SSH_KEY="${SSH_KEY}" SERVICE_PRINCIPAL_CLIENT_ID=${SERVICE_PRINCIPAL_CLIENT_ID} SERVICE_PRINCIPAL_SECRET=${SERVICE_PRINCIPAL_SECRET} location=${LOCATION}

echo "Deployment complete."