<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/Students/Student">
        <table border="1" align="left" >
            <tr><xsl:apply-templates/></tr>
        </table>
    </xsl:template>

    <xsl:template match="/Students/Student/Univer">
            <td width="200"><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Students/Student/Kurs">
        <td width="50"><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Students/Student/Facultet">
        <td width="500"><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Students/Student/Goods">
        <td width="1000"><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Students/Student/Price">
        <td width="200"><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>