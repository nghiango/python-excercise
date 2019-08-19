# https://app.codesignal.com/arcade/intro/level-9/xHvruDnQCx7mYom3T


def growingPlant(upSpeed, downSpeed, desiredHeight):
    # the formula is (upSpeed - downSpeed)*(days - 1) + upSpeed <= desireHeight
    if upSpeed >= desiredHeight:
        return 1
    distanceOneDay = upSpeed - downSpeed
    days = ((desiredHeight - upSpeed)/distanceOneDay) + 1
    return round(days)


print(growingPlant(100, 10, 910))
