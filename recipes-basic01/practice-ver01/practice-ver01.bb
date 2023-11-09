SUMMARY = "Simple practice - add folder and file to rootfs"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "file://hello_world.c"

DEMO_INSTALL_DIRECTORY ?= "/practice"

S = "${WORKDIR}"

#do_configure_prepend () {
#	export SDKTARGETSYSROOT="../recipe-sysroot"
#}

do_install () {
    install -d ${D}${DEMO_INSTALL_DIRECTORY}
    install -m 755 ${WORKDIR}/hello_world.c ${D}${DEMO_INSTALL_DIRECTORY}
}

FILES_${PN} = " \
	${DEMO_INSTALL_DIRECTORY} \
"