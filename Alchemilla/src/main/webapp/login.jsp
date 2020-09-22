<body>
	<div class="bgr">
		<form action="<%=request.getContextPath()%>/login" method="POST">
			<div class="container">
				<div class="row">
					<div class="col" style="width: 100px;">
						<b>Usuario</b>
					</div>
					<div class="col">
						<input type="text" placeholder="Nombre de Usuario"
							name ="nombreDeUsuario" required>						
					</div>
				</div>
				<div class="row">
					<div class="col">
						<b>Contraseña</b>
					</div>
					<div class="col">
						<input type="password" placeholder="Ingrese su contraseña"
						name="password" required>					
					</div>					
				</div>
				<div class="row">
					<div class="col"></div>
					<div class ="col">
						<p class="login_error"><%=request.getAttribute("error") == null ? "": request.getAttribute("err")%>
                                                </p>   
                                                <button type="submit">Ingresar</button>
                                        </div>
				</div>
			</div>		
		</form>		
	</div>
</body>