SUMMARY = "An implementation of JSON Schema validation for Python"
HOMEPAGE = "https://github.com/Julian/jsonschema"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=7a60a81c146ec25599a3e1dabb8610a8 \
                    file://json/LICENSE;md5=9d4de43111d33570c8fe49b4cb0e01af"

SRC_URI[sha256sum] = "df10e65c8f3687a48e93d0d348ce0ce5f897b5a28e9bbcbbe8f7c7eaf019e850"

inherit pypi python_hatchling

PACKAGES =+ "${PN}-tests"
FILES:${PN}-tests = "${libdir}/${PYTHON_DIR}/site-packages/jsonschema/tests"

DEPENDS += "${PYTHON_PN}-hatch-vcs-native"

PACKAGECONFIG ??= "format"
PACKAGECONFIG[format] = ",,,\
    ${PYTHON_PN}-idna \
    ${PYTHON_PN}-jsonpointer \
    ${PYTHON_PN}-webcolors \
    ${PYTHON_PN}-rfc3987 \
    ${PYTHON_PN}-strict-rfc3339 \
"
PACKAGECONFIG[nongpl] = ",,,\
    ${PYTHON_PN}-idna \
    ${PYTHON_PN}-jsonpointer \
    ${PYTHON_PN}-webcolors \
    ${PYTHON_PN}-rfc3986-validator \
    ${PYTHON_PN}-rfc3339-validator \
"

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-attrs \
    ${PYTHON_PN}-core \
    ${PYTHON_PN}-datetime \
    ${PYTHON_PN}-importlib-metadata \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-pprint \
    ${PYTHON_PN}-pyrsistent \
    ${PYTHON_PN}-zipp \
"

RDEPENDS:${PN}-tests = "${PN}"

BBCLASSEXTEND = "native nativesdk"
