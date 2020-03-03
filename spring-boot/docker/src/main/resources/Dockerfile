FROM gcr.io/distroless/java-debian10

ENTRYPOINT ["/usr/bin/tini", "-e", "130", "-e", "143", "--", "/usr/bin/java", "-jar", "/spring-boot-exit-code-app.jar"]

ADD rootfs.tar /

RUN ["/busybox/busybox", "sh", "-c", "set -e && for cmd in $(/busybox/busybox --list); do /busybox/busybox ln -s /busybox/busybox \"/bin/${cmd}\"; done"]

LABEL name="@docker.repository@" \
    version="@project.version@" \
    release="@project.version@" \
    build-date="@git.commit.time@" \
    vcs-url="@git.remote.origin.url@" \
    vcs-type="git" \
    vcs-ref="@git.commit.id@"