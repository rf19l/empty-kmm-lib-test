// swift-tools-version:5.3
import PackageDescription

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://pkgs.dev.azure.com/ryanjfoster94/_packaging/ryanjfoster94/maven/v1/com/publix/shared-kmmbridge/0.1.7/shared-kmmbridge-0.1.7.zip"
let remoteKotlinChecksum = "aa39b6bdaea198e060fe2a962efa664b7dea796ec4039312d1ee4fd1a99f3830"
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