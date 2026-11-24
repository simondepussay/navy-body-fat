# Navy式 体脂肪率診断

Petite application web **Java Servlet / JSP** qui calcule le taux de masse grasse avec la **formule de l'US Navy**, pour les hommes et pour les femmes.

Elle affiche le résultat avec une catégorie et une image : アスリート, 標準, ぽっちゃり ou 肥満.

## Formules (mesures en cm)

- **Homme** : `495 / (1.0324 − 0.19077·log10(taille_ventre − cou) + 0.15456·log10(taille)) − 450`
- **Femme** : `495 / (1.29579 − 0.35004·log10(taille_ventre + hanches − cou) + 0.22100·log10(taille)) − 450`

## Seuils

| Catégorie | Homme | Femme |
|---|---|---|
| アスリート | < 14 % | < 21 % |
| 標準 | < 25 % | < 32 % |
| ぽっちゃり | < 30 % | < 38 % |
| 肥満 | ≥ 30 % | ≥ 38 % |

## Structure (MVC)

- `servlet/FatCheck.java` : le contrôleur (`/FatCheck`)
- `model/Body.java` : le JavaBean qui contient les mesures et le résultat
- `model/FatCheckLogic.java` : le calcul et le choix de la catégorie
- `WEB-INF/jsp/fatCheck.jsp` : le formulaire
- `WEB-INF/jsp/fatCheckResult.jsp` : la page de résultat

## Lancer le projet

1. Dans Eclipse, ouvre **ファイル → インポート → 既存プロジェクトをワークスペースへ** et choisis ce dossier.
2. Ajoute le projet à un serveur **Tomcat 10 ou plus récent** (le code utilise `jakarta.servlet`).
3. Ouvre `http://localhost:8080/jv16_kadai03_A22/`.

## Licence

MIT
