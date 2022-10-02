load("@rules_java//java:defs.bzl", "java_test")
load("@rules_jvm_external//:defs.bzl", "artifact")

package(default_visibility = ["//visibility:public"])

test_suite(
    name = "collinear",
    tests = [
        ":brute_collinear_points_test",
        ":point_test",
    ],
)

java_test(
    name = "brute_collinear_points_test",
    srcs = ["TestBruteCollinearPoints.java"],
    test_class = "io.tstodden.algorithms.collinear.TestBruteCollinearPoints",
    deps = [
        "//src/main/io/tstodden/algorithms/collinear",
        artifact("junit:junit"),
    ],
)

java_test(
    name = "point_test",
    srcs = ["TestPoint.java"],
    test_class = "io.tstodden.algorithms.collinear.TestPoint",
    deps = [
        "//src/main/io/tstodden/algorithms/collinear",
        artifact("junit:junit"),
    ],
)
