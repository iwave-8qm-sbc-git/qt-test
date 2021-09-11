# Copyright (c) 2020 iWave Systems Technologies Pvt. Ltd.

DESCRIPTION = "iwtest files"
PROVIDES += "${PN}"
LICENSE = "GPLv2+"

COMPATIBLE_MACHINE = "(imx8qm-iwg27m|imx8qm-iwg27m-8gb)"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

LIC_FILES_CHKSUM = "file://GPL-2;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "file://mipi_dsi_rotate.sh file://GPL-2 file://tfr.mp4 file://iwg27m_hello_world_m40.bin file://iwg27m_hello_world_m41.bin file://iwg27m_rpmsg_lite_pingpong_rtos_linux_remote_m40.bin file://iwg27m_rpmsg_lite_pingpong_rtos_linux_remote_m41.bin file://iwg27m_rpmsg_lite_str_echo_rtos_m40.bin file://iwg27m_rpmsg_lite_str_echo_rtos_m41.bin file://weston"
FILES_${PN} = "iwtest /etc/default"
S = "${WORKDIR}"

inherit deploy
addtask deploy before do_build after do_install
do_deploy () {
    install -m 0644 ${S}/iwg27m_hello_world_m40.bin ${DEPLOYDIR}
    install -m 0644 ${S}/iwg27m_hello_world_m41.bin ${DEPLOYDIR}
    install -m 0644 ${S}/iwg27m_rpmsg_lite_pingpong_rtos_linux_remote_m40.bin ${DEPLOYDIR}
    install -m 0644 ${S}/iwg27m_rpmsg_lite_pingpong_rtos_linux_remote_m41.bin ${DEPLOYDIR}
    install -m 0644 ${S}/iwg27m_rpmsg_lite_str_echo_rtos_m40.bin ${DEPLOYDIR}
    install -m 0644 ${S}/iwg27m_rpmsg_lite_str_echo_rtos_m41.bin ${DEPLOYDIR}
}

do_install() {
    mkdir -p ${D}/iwtest ${D}/etc/default
    install -m 0644 ${S}/tfr.mp4 ${D}/iwtest
    install -m 0644 ${S}/mipi_dsi_rotate.sh ${D}/iwtest
    chmod   +x ${D}/iwtest/*

    install -m 0644 ${S}/weston ${D}/etc/default
    chmod   +x ${D}/etc/default/weston
}
