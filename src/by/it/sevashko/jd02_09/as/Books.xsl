<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/Catalog">
        <head/>
        <body>
            <table border="1">
                <tr>
                    <td>
                        Сущности
                    </td>
                </tr>
                <xsl:apply-templates/>
            </table>
        </body>
    </xsl:template>

    <xsl:template match="/Catalog/Category">
        <tr>
            <td>
                <xsl:apply-templates/>
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="/Catalog/Category/CategoryName">
        <tr>
            <td>
                <xsl:apply-templates/>
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="/Catalog/Category/Books">
        <tr>
            <td>
                <xsl:apply-templates/>
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="/Catalog/Category/Books/Book">
        <tr>
            <td><xsl:apply-templates/></td>
        </tr>
    </xsl:template>

    <xsl:template match="/Catalog/Category/Books/Book/Name">
        <tr>
            <td><xsl:apply-templates/></td>
        </tr>
    </xsl:template>

    <xsl:template match="/Catalog/Category/Books/Book/Author">
        <tr>
            <td><xsl:apply-templates/></td>
        </tr>
    </xsl:template>

    <xsl:template match="/Catalog/Category/Books/Book/Price">
        <tr>
            <td><xsl:apply-templates/></td>
        </tr>
    </xsl:template>

    <xsl:template match="/Catalog/Category/Books/Book/BookDetails">
        <tr>
            <td><xsl:apply-templates/></td>
        </tr>
    </xsl:template>

    <xsl:template match="/Catalog/Category/Books/Book/BookDetails/Publisher">
        <tr>
            <td><xsl:apply-templates/></td>
        </tr>
    </xsl:template>

    <xsl:template match="/Catalog/Category/Books/Book/BookDetails/Language">
        <tr>
            <td><xsl:apply-templates/></td>
        </tr>
    </xsl:template>

    <xsl:template match="/Catalog/Category/Books/Book/BookDetails/NumOfPages">
        <tr>
            <td><xsl:apply-templates/></td>
        </tr>
    </xsl:template>

    <xsl:template match="/Catalog/Category/Books/Book/BookDetails/Edition">
        <tr>
            <td><xsl:apply-templates/></td>
        </tr>
    </xsl:template>

</xsl:stylesheet>



