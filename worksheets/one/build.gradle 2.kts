plugins {
	`build-scan`
    kotlin("jvm", "1.1.4-3") 
}

repositories {
    jcenter() 
}

dependencies {
    implementation(kotlin("stdlib", "1.1.4-3")) 
}

buildScan {
    setLicenseAgreementUrl("https://gradle.com/terms-of-service") 
    setLicenseAgree("yes")

    publishAlways() 
}