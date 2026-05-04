$path = "c:\Users\User\Documents\NetBeansProjects\Lamar_OnlineFoodOrderingSystem\Lamar_OnlineFoodOrderingSystem _.drawio"
$utf8 = New-Object System.Text.UTF8Encoding($false)
$content = [System.IO.File]::ReadAllText($path, $utf8)

$badPlus = "+" + [char]0x00C2 + [char]0x00A0
while ($content.Contains($badPlus)) { $content = $content.Replace($badPlus, "+ ") }

$nbspPlus = "+" + [char]0x00A0
while ($content.Contains($nbspPlus)) { $content = $content.Replace($nbspPlus, "+ ") }

$old1 = 'value="+ FoodItem()&#xa;+ &lt;&lt;Full Constructor&gt;&gt;&#xa;+ Setters/Getters&#xa;+ calculateDiscount() : double&#xa;+ calculateFinalPrice(): double&#xa;+ toString(): String" vertex="1">'
$new1 = 'value="+ FoodItem()&#xa;+ &lt;&lt;Full Constructor&gt;&gt;&#xa;+ Setters/Getters&#xa;+ calculateDiscount() : double&#xa;+ calculateFinalPrice(): double&#xa;+ showDetails(): void&#xa;+ isSpicyHot(): boolean&#xa;+ toString(): String" vertex="1">'
$content = $content.Replace($old1, $new1)

$old2 = 'value="+ DrinkItem()&#xa;+ &lt;&lt;Full Constructor&gt;&gt;&#xa;+ Setters/Getters&#xa;+ calculateDiscount() : double&#xa;+ calculateFinalPrice(): double&#xa;+ toString(): String" vertex="1">'
$new2 = 'value="+ DrinkItem()&#xa;+ &lt;&lt;Full Constructor&gt;&gt;&#xa;+ Setters/Getters&#xa;+ calculateDiscount() : double&#xa;+ calculateFinalPrice(): double&#xa;+ showDetails(): void&#xa;+ toString(): String" vertex="1">'
$content = $content.Replace($old2, $new2)

$old3 = 'value="+ DessertItem()&#xa;+ &lt;&lt;Full Constructor&gt;&gt;&#xa;+ Setters/Getters&#xa;+ calculateDiscount() : double&#xa;+ calculateFinalPrice(): double&#xa;+ toString(): String" vertex="1">'
$new3 = 'value="+ DessertItem()&#xa;+ &lt;&lt;Full Constructor&gt;&gt;&#xa;+ Setters/Getters&#xa;+ calculateDiscount() : double&#xa;+ calculateFinalPrice(): double&#xa;+ showDetails(): void&#xa;+ toString(): String" vertex="1">'
$content = $content.Replace($old3, $new3)

$pat102 = '<mxGeometry height="102" width="240" y="78" as="geometry" />'
$idx = $content.IndexOf($pat102)
if ($idx -ge 0) { $content = $content.Substring(0,$idx) + '<mxGeometry height="130" width="240" y="78" as="geometry" />' + $content.Substring($idx + $pat102.Length) }
$idx = $content.IndexOf($pat102)
if ($idx -ge 0) { $content = $content.Substring(0,$idx) + '<mxGeometry height="116" width="240" y="78" as="geometry" />' + $content.Substring($idx + $pat102.Length) }
$content = $content.Replace('<mxGeometry height="112" width="240" y="58" as="geometry" />', '<mxGeometry height="126" width="240" y="58" as="geometry" />')

$content = $content.Replace('<mxGeometry height="180" width="240" x="174" y="160" as="geometry" />', '<mxGeometry height="208" width="240" x="174" y="160" as="geometry" />')
$content = $content.Replace('<mxGeometry height="180" width="240" x="174" y="350" as="geometry" />', '<mxGeometry height="194" width="240" x="174" y="350" as="geometry" />')
$content = $content.Replace('<mxGeometry height="170" width="240" x="174" y="560" as="geometry" />', '<mxGeometry height="184" width="240" x="174" y="560" as="geometry" />')

$old5 = 'value="+ Order()&lt;br&gt;+ &amp;lt;&amp;lt;Full Constructor&amp;gt;&amp;gt;&lt;br&gt;+ Setters/Getters&lt;br&gt;+ calculateOrderTotal(): double&lt;br&gt;+ updateStatus(): void&lt;br&gt;+ toString(): String" vertex="1">'
$new5 = 'value="+ Order()&lt;br&gt;+ &amp;lt;&amp;lt;Full Constructor&amp;gt;&amp;gt;&lt;br&gt;+ Setters/Getters&lt;br&gt;+ calculateOrderTotal(): double&lt;br&gt;+ calculateDiscount(): double&lt;br&gt;+ applyDiscount(): double&lt;br&gt;+ updateStatus(): void&lt;br&gt;+ toString(): String" vertex="1">'
$content = $content.Replace($old5, $new5)
$content = $content.Replace('<mxGeometry height="106" width="280" y="144" as="geometry" />', '<mxGeometry height="134" width="280" y="144" as="geometry" />')
$content = $content.Replace('<mxGeometry height="250" width="280" x="920" y="620" as="geometry" />', '<mxGeometry height="278" width="280" x="920" y="620" as="geometry" />')

$old6 = '<mxCell id="xr3dkqV3huZx18hUsRTn-43" edge="1" parent="1" source="xr3dkqV3huZx18hUsRTn-27" style="endArrow=diamondThin;endFill=0;endSize=24;html=1;rounded=0;exitX=0.5;exitY=1;exitDx=0;exitDy=0;entryX=1;entryY=0.5;entryDx=0;entryDy=0;" target="xr3dkqV3huZx18hUsRTn-36" value="">'
$new6 = '<mxCell id="xr3dkqV3huZx18hUsRTn-43" edge="1" parent="1" source="xr3dkqV3huZx18hUsRTn-27" style="endArrow=diamondThin;endFill=1;endSize=24;html=1;rounded=0;exitX=0.5;exitY=1;exitDx=0;exitDy=0;entryX=1;entryY=0.5;entryDx=0;entryDy=0;" target="xr3dkqV3huZx18hUsRTn-36" value="1">'
$content = $content.Replace($old6, $new6)

$lf = "`n"
$newEdge = '        <mxCell id="xr3dkqV3huZx18hUsRTn-44" edge="1" parent="1" source="xr3dkqV3huZx18hUsRTn-36" style="endArrow=block;endSize=16;endFill=0;dashed=1;html=1;rounded=0;" target="xr3dkqV3huZx18hUsRTn-1" value="">' + $lf + '          <mxGeometry relative="1" as="geometry" />' + $lf + '        </mxCell>' + $lf + '      </root>'
$content = $content.Replace('      </root>', $newEdge)

[System.IO.File]::WriteAllText($path, $content, $utf8)
Write-Host "Done"
