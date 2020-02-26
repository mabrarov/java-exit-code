FROM centos:7

RUN curl -jksSL \
      https://copr.fedorainfracloud.org/coprs/vbatts/bazel/repo/epel-7/vbatts-bazel-epel-7.repo \
      -o /etc/yum.repos.d/vbatts-bazel-epel-7.repo  && \
    yum install -y bazel && \
    yum clean -y all

RUN yum install -y gcc && \
    yum install -y git && \
    yum install -y python3 && \
    yum install -y docker-client && \
    yum clean -y all
