#!/bin/bash

# Variables
RESOURCE_GROUP="test-rg"
LOCATION="eastus"
DEPLOYMENT_NAME="TennisLeagueInfraDeployment"
BICEP_FILE="../bicep/main.bicep"
PARAMETERS_FILE="../bicep/parameters.json"


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