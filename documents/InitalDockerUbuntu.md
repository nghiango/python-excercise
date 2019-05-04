- Refference: https://docs.docker.com/install/linux/docker-ce/ubuntu/
## Update package index
>sudo apt-get update

## Install packages to allow apt to use a repository over HTTPS:
>sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common

## Add Docker's official GPG key: 
>curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

## Verify the fingerprint
>sudo apt-key fingerprint 0EBFCD88

## Add Docker repository to APT sources:
>sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable"

## Update the apt package index
>sudo apt-get update

## Install the latest version of Docker CE and containerd
>sudo apt-get install docker-ce docker-ce-cli containerd.io
