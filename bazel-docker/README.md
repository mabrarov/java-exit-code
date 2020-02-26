# Bazel Docker Image

Docker image [Bazel](https://bazel.build/)

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
