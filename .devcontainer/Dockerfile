# FROM openjdk:17.0.1
FROM ubuntu:20.04
ARG DEBIAN_FRONTEND=noninteractive

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y \
      procps \
      iputils-ping \
      net-tools \
      lsb-release \
      git
RUN apt-get install -y openjdk-17-jdk
# procps: to support command 'ps'
# iputils-ping: to support command 'ping' (https://linuxconfig.org/ping-command-not-found-on-ubuntu-20-04-focal-fossa-linux) [Manfred, 19sep2021]
# net-tools: to support command such as 'arp', 'ifconfig', 'netstat', etc. (https://helpmanual.io/packages/apt/net-tools/) [Manfred, 26sep2021]
# lsb-release: to support commmand 'lsb_release -a' [Manfred, 15jan2022]
# git: to support command 'git' [Manfred, 15jan2022]
# You can safely remove the packages you don't want. [Manfred, 08oct2021]

# Install latest stable release of git:
RUN apt update
RUN apt -y install software-properties-common dirmngr apt-transport-https lsb-release ca-certificates
RUN add-apt-repository ppa:git-core/ppa
RUN apt-get update
RUN apt install -y git

# Create non-root user (zero trust principle, least privileged principle)
RUN groupadd -g 1000 -r dev && \
   useradd -u 1000 -r -g dev -m -s $(which bash) dev
# Option '-m' to create home directory (see https://askubuntu.com/a/393470)
# Option '-s' to set shell for this user (see comment in https://askubuntu.com/a/393470)
# Option '-r' creates a system user which does not expire (see https://linuxize.com/post/how-to-create-users-in-linux-using-the-useradd-command/)

# How to add sudo support for the non-root user is described at https://code.visualstudio.com/remote/advancedcontainers/add-nonroot-user#_creating-a-nonroot-user
# However, standard practice is not to add sudo support to keep security tight. Instead, perform steps that require
# privileges as RUN directives in the Dockerfile.

# Create working directory. Ownership will be changed in entrypoint.sh which
# executes *after* the volume has been mounted.
RUN mkdir /src

# Copy entrypoint script into container, make it executable, then make it the entrypoint for the container:
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh
# Option '+x' adds executable flag to the file
ENTRYPOINT ["/entrypoint.sh"]
