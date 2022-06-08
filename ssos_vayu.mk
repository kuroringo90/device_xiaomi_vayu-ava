#
# Copyright (C) 2018-2021 ArrowOS
#
# SPDX-License-Identifier: Apache-2.0
#

# Inherit common products
$(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)

# Inherit device configurations
$(call inherit-product, device/xiaomi/vayu/device.mk)

# Inherit some common ShapeShiftOS stuff.
$(call inherit-product, vendor/ssos/config/common_full_phone.mk)

TARGET_FACE_UNLOCK_SUPPORTED := true

# Bootanimation
TARGET_BOOT_ANIMATION_RES := 1080

# GApps
WITH_GAPPS := true
TARGET_ARCH := arm64

# Device identifier. This must come after all inclusions.
PRODUCT_NAME := ssos_vayu
PRODUCT_DEVICE := vayu
PRODUCT_BRAND := POCO
PRODUCT_MODEL := Poco X3 Pro
PRODUCT_MANUFACTURER := Xiaomi

PRODUCT_GMS_CLIENTID_BASE := android-xiaomi

PRODUCT_BUILD_PROP_OVERRIDES += \
    PRIVATE_BUILD_DESC="vayu_id-user 12 SKQ1.211006.001 V13.0.2.0.SJUIDXM release-keys" \
    PRODUCT_NAME=vayu_global \
    PRODUCT_MODEL=M2102J20SI

BUILD_FINGERPRINT := POCO/vayu_id/vayu:12/SKQ1.211006.001/V13.0.2.0.SJUIDXM:user/release-keys
