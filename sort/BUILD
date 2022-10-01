load("@rules_java//java:defs.bzl", "java_binary", "java_library")

java_library(
    name = "sort_lib",
    srcs = glob(["*.java"]),
    deps = ["@algs4//jar"],
)

java_binary(
    name = "insertion",
    main_class = "sort.Insertion",
    runtime_deps = [":sort_lib"],
)

java_binary(
    name = "merge",
    main_class = "sort.Merge",
    runtime_deps = [":sort_lib"],
)

java_binary(
    name = "selection",
    main_class = "sort.Selection",
    runtime_deps = [":sort_lib"],
)
