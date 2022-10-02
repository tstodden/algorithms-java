load("@rules_java//java:defs.bzl", "java_binary", "java_library")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "sort",
    srcs = glob(["*.java"]),
    deps = ["@algs4//jar"],
)

java_binary(
    name = "insertion",
    main_class = "io.tstodden.algorithms.sort.Insertion",
    runtime_deps = [":sort"],
)

java_binary(
    name = "merge",
    main_class = "io.tstodden.algorithms.sort.Merge",
    runtime_deps = [":sort"],
)

java_binary(
    name = "merge_bottom_up",
    main_class = "io.tstodden.algorithms.sort.MergeBottomUp",
    runtime_deps = [":sort"],
)

java_binary(
    name = "selection",
    main_class = "io.tstodden.algorithms.sort.Selection",
    runtime_deps = [":sort"],
)
