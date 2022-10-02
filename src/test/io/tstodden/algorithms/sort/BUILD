load("@rules_java//java:defs.bzl", "java_test")
load("@rules_jvm_external//:defs.bzl", "artifact")

package(default_visibility = ["//visibility:public"])

test_suite(
    name = "sort",
    tests = [
        ":insertion_test",
        ":merge_bottom_up_test",
        ":merge_test",
        ":selection_test",
    ],
)

java_test(
    name = "merge_test",
    srcs = ["TestMerge.java"],
    test_class = "io.tstodden.algorithms.sort.TestMerge",
    deps = [
        "//src/main/io/tstodden/algorithms/sort",
        artifact("junit:junit"),
    ],
)

java_test(
    name = "insertion_test",
    srcs = ["TestInsertion.java"],
    test_class = "io.tstodden.algorithms.sort.TestInsertion",
    deps = [
        "//src/main/io/tstodden/algorithms/sort",
        artifact("junit:junit"),
    ],
)

java_test(
    name = "merge_bottom_up_test",
    srcs = ["TestMergeBottomUp.java"],
    test_class = "io.tstodden.algorithms.sort.TestMergeBottomUp",
    deps = [
        "//src/main/io/tstodden/algorithms/sort",
        artifact("junit:junit"),
    ],
)

java_test(
    name = "selection_test",
    srcs = ["TestSelection.java"],
    test_class = "io.tstodden.algorithms.sort.TestSelection",
    deps = [
        "//src/main/io/tstodden/algorithms/sort",
        artifact("junit:junit"),
    ],
)
