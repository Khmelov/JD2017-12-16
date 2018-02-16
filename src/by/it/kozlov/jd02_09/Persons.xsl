﻿<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/Persons">
        <head/>
        <body>
            <table border="1">
                <tr>
                    <td>Email</td>
                    <td>Nickname</td>
                    <td>Password</td>
                    <td>Address</td>
                    <td>PhoneNumber</td>
                    <td>Model</td>
                </tr>
                <xsl:apply-templates/>
            </table>
        </body>
    </xsl:template>

    <xsl:template match="Persons/Person">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="Persons/Person/Email">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="Persons/Person/Nickname">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="Persons/Person/Password">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="Persons/Person/Address">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="Persons/Person/PhoneNumber">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="Persons/Person/Brand">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="Persons/Person/Brand/Title">

        <xsl:apply-templates/>
        <hr/>
    </xsl:template>

    <xsl:template match="Persons/Person/Brand/Model">
        <xsl:apply-templates/>
        <br/>
    </xsl:template>

    <xsl:template match="Persons/Person/Brand/Model/Name">
        Name:
        <xsl:apply-templates/>
        <br/>
    </xsl:template>

    <xsl:template match="Persons/Person/Brand/Model/Class">
        Class:
        <xsl:apply-templates/>
        <br/>
    </xsl:template>

    <xsl:template match="Persons/Person/Brand/Model/Price">
        Price:
        <xsl:apply-templates/>
        <br/>
    </xsl:template>

    <xsl:template match="Persons/Person/Brand/Model/Years">
        Years:
        <xsl:apply-templates/>
        <br/>
    </xsl:template>
</xsl:stylesheet>