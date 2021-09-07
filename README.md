# GrailsProject


# MOUSSAOUI Mohammed 
# Projet :
Notre application lecoincoin se divise sur trois parties : </p>
Un backend qui permet à l’admin de créer un utilisateur en précisant un username qui n’existe pas déjà, un password et un rôle, de le modifier, ou de le supprimer. Également, il peut appliquer les mêmes actions pour les annonces, avec la possibilité d’ajouter une ou plusieurs images. Pour les deux.</p>
Le Backend n’est accessible que si l’utilisateur est connecté en Admin ou Modérateur</p>
Un Front end permet à tous les utilisateur (Connecté ou non) de visualiser les annonces actuelles.</p>
Un Api est également disponible qui fournit les endpoints suivants :</p>
/users
# GET - La liste des utilisateurs enregistrés dans la BD</p>
# POST création d’un nouvel utilisateur</p>
paramètres : [username : texte, password : texte]</p>
réponses  : </p>
201 en cas de création</p>
un message d’erreur, si le username est déjà pris, ou erreur lors de l’enregistrement</p>
/user/{id}</p>
# GET - les informations d’un utilisateur ainsi que ses rôles (dans réponse.authorities)</p>
réponses  : </p>
404 utilisateur n’existe pas</p>
# PUT - Modifier toutes les informations d’un utilisateur</p>
paramètres : [username : texte, password : texte]</p>
réponses  : </p>
201 en cas de modification</p>
404 utilisateur n’existe pas</p>
# PATCH - Modifier certaines informations d’un utilisateur</p>
réponses  : </p>
201 en cas de modification</p>
404 utilisateur n’existe pas</p>
# DELETE  - Supprimer un utilisateur</p>
réponses  : </p>
201 en cas de suppression</p>
404 utilisateur n’existe pas</p>
/salesAd</p>
# GET - La liste des annonces enregistrés dans la BD</p>
# POST création d’une nouvelle annonce</p>
paramètres : [title : texte, descShort: texte, descLong: texte, price: float]</p>
réponses  : </p>
201 en cas de création</p>
un message d’erreur si l’enregistrement ne passe pas</p>
/saleAd/{id}</p>
# GET - les informations d’une annonce </p>
réponses  : </p>
404 annonce n’existe pas</p>
# PUT - Modifier toutes les informations d’une annonce</p>
paramètres : [title : texte, descShort: texte, descLong: texte, price: float]</p>
réponses  : 
201 en cas de modification
404 annonce n’existe pas
# PATCH - Modifier certaines informations d’une annonce 
réponses  : 
201 en cas de modification
404 annonce n’existe pas
# DELETE  - Supprimer une annonce
réponses  : 
201 en cas de suppression
404 annonce n’existe pas
