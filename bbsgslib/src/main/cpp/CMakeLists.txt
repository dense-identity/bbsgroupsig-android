cmake_minimum_required(VERSION 3.18.1)

project(bbsgslib VERSION 1.0.0 LANGUAGES C CXX)

set(BUILD_BBSGS_JNI ON CACHE BOOL "Enable dependency's JNI build" FORCE)
set(BUILD_BBSGS_TESTING OFF CACHE BOOL "Build the tests" FORCE)
set(BUILD_BBSGS_BENCHMARK OFF CACHE BOOL "Build the benchmarks" FORCE)
set(MCL_TEST_WITH_GMP OFF CACHE BOOL "Turn of MCL Tests" FORCE)

include(FetchContent)
FetchContent_Declare(
        bbsgroupsig
        GIT_REPOSITORY https://github.com/dense-identity/bbsgroupsig.git
        GIT_TAG v1.1.1
)

FetchContent_MakeAvailable(bbsgroupsig)
