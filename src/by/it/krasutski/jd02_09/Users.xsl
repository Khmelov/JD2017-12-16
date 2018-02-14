<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/Users">
        <table border="1">
            <tr><td>Email</td><td>NickName</td><td>Password</td><td>Cart</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Users/User">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Users/User/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Users/User/Nickname">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Users/User/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Users/User/Cart">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>