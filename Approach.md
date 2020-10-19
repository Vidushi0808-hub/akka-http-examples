# Approach for execution of CICD:

## Files created:

### Jenkinsfile: 
It contains a pipeline script for multiple stages of deployment, testing and production.
It has build instructions for building a docker image and pushing it to dockerhub repository.

### Dockerfile:
It is a basic dockerfile that is used in the Jenkinsfile for CICD workflow. 

### deployment.yaml:
It takes the code from the dockerhub registry and deploys the containers in the GKE cluster.


## Procedure:
1. With each commit, the build is triggered in jenkins.
2. In development stage, code is compiled.
3. In testing stage, code is tested against several test-cases for errors.
4. In production stage:
    (a)jar file is created and artifacts generated are archived. 
    (b)Docker image is tagged with the build number.
    (c)Docker image is pushed to docker hub.
    (d)Image is retieved and deployed to GKE use deployment.yaml file through kubernetes.
    (e)Workspace is cleaned.
    (f)Mail is sent as a post action to check the status of tasks.
