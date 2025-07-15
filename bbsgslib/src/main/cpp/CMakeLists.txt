# Define the project for your Android library module.
cmake_minimum_required(VERSION 3.18.1)
project(bbsgslib VERSION 1.0.0 LANGUAGES C CXX)

set(MCL_USE_LLVM          OFF CACHE BOOL "Disable LLVM optimizations for cross-compilation" FORCE)
set(BUILD_BBSGS_JNI       ON  CACHE BOOL "Enable dependency's JNI build" FORCE)
set(BUILD_BBSGS_TESTING   OFF CACHE BOOL "Disable tests" FORCE)
set(BUILD_BBSGS_BENCHMARK OFF CACHE BOOL "Disable benchmarks" FORCE)
set(MCL_TEST_WITH_GMP     OFF CACHE BOOL "Disable MCL tests" FORCE)

# --- Fetch Dependency ---
# Fetch the bbsgroupsig C++ library and build its targets.
include(FetchContent)
FetchContent_Declare(
        bbsgroupsig
        GIT_REPOSITORY https://github.com/dense-identity/bbsgroupsig.git
        GIT_TAG        v1.1.1
)
FetchContent_MakeAvailable(bbsgroupsig)