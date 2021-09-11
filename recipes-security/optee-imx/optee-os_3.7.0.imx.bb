# Copyright (C) 2020 iWave Systems Technologies Pvt Ltd
require recipes-security/optee-imx/optee-os.imx.inc

SRCBRANCH = "iwave_5.4.24_2.1.0-iwg27m-r4.0-rel1.0"
OPTEE_OS_SRC = "git://git-codecommit.ap-south-1.amazonaws.com/v1/repos/imx-optee-os-iWave;protocol=https"
SRC_URI = "${OPTEE_OS_SRC};branch=${SRCBRANCH}"
SRCREV = "2d4da7a088dbf6a6d6f477a56e877f0a193a3c94"

PLATFORM_FLAVOR_mx8qm = "${@bb.utils.contains('MACHINE', 'imx8qm-iwg27m', 'mx8qm_iwg27m', 'mx8qm_iwg27m_8gb', d)}"

COMPATIBLE_MACHINE = "(imx8qm-iwg27m|imx8qm-iwg27m-8gb)"
