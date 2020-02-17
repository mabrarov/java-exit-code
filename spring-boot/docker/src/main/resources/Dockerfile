FROM gcr.io/distroless/java:11

ADD rootfs.tar /

ENTRYPOINT ["/tini", "-e", "130", "-e", "143", "--", "/usr/bin/java", "-jar", "/spring-boot-exit-code-app.jar"]

LABEL name="@docker.repository@" \
    version="@project.version@" \
    release="@project.version@" \
    build-date="@git.commit.time@" \
    vcs-url="@git.remote.origin.url@" \
    vcs-type="git" \
    vcs-ref="@git.commit.id@"