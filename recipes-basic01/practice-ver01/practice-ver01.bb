SUMMARY = "Simple practice - add folder and file to rootfs"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

BangNguyen_Repo ?= "github.com/bangnguyendev/SmartClock.git"
BangNguyen_Branch ?= "master"
BangNguyen_URL ?= "https"
SRCREV = "cc307a49f2fb264b2ac86ccd3d0d53556c6b265e"

SRC_URI = " \
    file://hello_world.c \
    git://${BangNguyen_Repo};protocol=${BangNguyen_URL};branch=${BangNguyen_Branch}  \
"

DEMO_INSTALL_DIRECTORY ?= "/practice"
BangNguyen_Dir_Root ?= "BangRZ"

S = "${WORKDIR}"

#do_configure_prepend () {
#	export SDKTARGETSYSROOT="../recipe-sysroot"
#}

do_install () {
    install -d ${D}${DEMO_INSTALL_DIRECTORY}
    install -d ${D}${DEMO_INSTALL_DIRECTORY}/${BangNguyen_Dir_Root}
    install -m 755 ${WORKDIR}/hello_world.c ${D}${DEMO_INSTALL_DIRECTORY}
    install -m 775 ${WORKDIR}/git/src/main/main.ino ${D}${DEMO_INSTALL_DIRECTORY}/${BangNguyen_Dir_Root}
}

FILES_${PN} = " \
	${DEMO_INSTALL_DIRECTORY} \
"