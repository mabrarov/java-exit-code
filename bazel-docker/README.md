# Bazel Docker Image

Docker image with [Bazel](https://bazel.build/)

## Building

```bash
docker build -t abrarov/bazel bazel-docker/src
```

## Testing

```bash
docker run --rm abrarov/bazel bazel --version
```

Expected output looks like

```text
bazel 1.2.1
```

## Building "Distroless" Docker Images

Building docker image with JDK 11 based on Debian 10 from ["Distroless" Docker Images](https://github.com/GoogleContainerTools/distroless).

1. Clone [GoogleContainerTools/distroless](https://github.com/GoogleContainerTools/distroless)
1. Set current directory to the directory where GoogleContainerTools/distroless repository is cloned
1. Use command

   ```bash
   output_dir="$(dirname "$(pwd)")/bazel-out" && \
   docker run --rm \
     -v "$(pwd):$(pwd)" \
     -v "${output_dir}:${output_dir}" \
     -v /var/run/docker.sock:/var/run/docker.sock \
     -w "$(pwd)" \
     abrarov/bazel \
     bazel --output_base="${output_dir}" run //java:java11_debian10
   ```

1. Find built docker image at your docker host with bazel/java:java11_debian10 name
