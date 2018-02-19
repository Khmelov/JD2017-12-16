<?xml version="1.0" encoding="UTF-8" ?>
    <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <xsl:output method="html"/>
        <xsl:template match="/Persons">
            <head/>
            <body>
                <table border ='1'>
                    <tr>
                        <td>
                            Email
                        </td>
                        <td>
                            Ник
                        </td>
                        <td>
                            Пароль
                        </td>
                        <td>
                            Объявления
                        </td>
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

       <xsl:template match="Persons/Person/Password">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

        <xsl:template match="Persons/Person/Nickname">
            <td>
                <xsl:apply-templates/>
            </td>
        </xsl:template>

        <xsl:template match="Persons/Person/Ads">
            <td>
                <xsl:apply-templates/>
            </td>
        </xsl:template>

        <xsl:template match="Persons/Person/Ads/Ad">
            <td>
                <xsl:apply-templates/>
            </td>
        </xsl:template>

        <xsl:template match="Persons/Person/Ads/Ad/Description">
            <td>
                Описание:
                <xsl:apply-templates/>
            </td>
        </xsl:template>

        <xsl:template match="Persons/Person/Ads/Ad/Carrying">
            <td>
                Грузоподъёмность:
                <xsl:apply-templates/>
            </td>
        </xsl:template>

        <xsl:template match="Persons/Person/Ads/Ad/Volume">
            <td>
                Объём кузова:
                <xsl:apply-templates/>
            </td>
        </xsl:template>

        <xsl:template match="Persons/Person/Ads/Ad/Tariff">
            <td>
                Тариф перевозки за 1 км пути:
                <xsl:apply-templates/>
            </td>
        </xsl:template>
    </xsl:stylesheet>