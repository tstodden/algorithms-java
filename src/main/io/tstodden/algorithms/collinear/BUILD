load("@rules_java//java:defs.bzl", "java_binary", "java_library")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "collinear",
    srcs = glob(["*.java"]),
    deps = ["@algs4//jar"],
)

java_binary(
    name = "brute_collinear_points",
    data = [
        "data/input400.txt",
        "data/input8.txt",
    ],
    main_class = "io.tstodden.algorithms.collinear.BruteCollinearPoints",
    runtime_deps = [":collinear"],
)
