// swift-tools-version:5.3
import PackageDescription

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://pkgs.dev.azure.com/ryanjfoster94/_packaging/ryanjfoster94/maven/v1/empty-kmm-lib-test/shared-kmmbridge/0.1.5/shared-kmmbridge-0.1.5.zip"
let remoteKotlinChecksum = "52bd72c9ede724abdf2c1368e6c90bf84d1a95839a367781e8f3d8e07ad6f8ba"
let packageName = "PublixAnalyticsLogger"
// END KMMBRIDGE BLOCK

let package = Package(
    name: packageName,
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: packageName,
            targets: [packageName]
        ),
    ],
    targets: [
        .binaryTarget(
            name: packageName,
            url: remoteKotlinUrl,
            checksum: remoteKotlinChecksum
        )
        ,
    ]
)