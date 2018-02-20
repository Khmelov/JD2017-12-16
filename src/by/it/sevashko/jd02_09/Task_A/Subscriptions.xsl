<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/users/user/subscriptions">
        <table border="1">
            <tr>
                <td>Название издания</td>
                <td>Период подписки</td>
                <td>Начало подписки</td>
                <td>Конец подписки</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/users/user/subscriptions/subscription">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/users/user/subscriptions/subscription/publication">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

    <xsl:template match="/users/user/subscriptions/subscription/period">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

    <xsl:template match="/users/user/subscriptions/subscription/startsubscription">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
>
    <xsl:template match="/users/user/subscriptions/subscription/endsubscription">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

    <xsl:template match="/users/user/subscriptions/subscription/price">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

</xsl:stylesheet>